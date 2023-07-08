package com.neoris.pruebatecnica.service.serviceImpl;

import com.neoris.pruebatecnica.dto.ClienteDto;
import com.neoris.pruebatecnica.dto.ClientePatchDto;
import com.neoris.pruebatecnica.dto.PersonaDto;
import com.neoris.pruebatecnica.dto.ReporteDto;
import com.neoris.pruebatecnica.entity.ClienteEntity;
import com.neoris.pruebatecnica.entity.MovimientoEntity;
import com.neoris.pruebatecnica.enums.MensajesErrorNegocio;
import com.neoris.pruebatecnica.enums.TipoCuentaEnum;
import com.neoris.pruebatecnica.enums.TipoMovimientoEnum;
import com.neoris.pruebatecnica.exception.NeorisException;
import com.neoris.pruebatecnica.mapper.MapClientePatchDtoToClienteEntity;
import com.neoris.pruebatecnica.repository.ClienteRepository;
import com.neoris.pruebatecnica.repository.PersonaRepository;
import com.neoris.pruebatecnica.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClienteDto crearCliente(ClienteDto clienteDto) throws NeorisException {
        if(this.consultarClientePorIdentificacion(clienteDto.getPersona().getIdentificacion()).isPresent()){
            throw new NeorisException(MensajesErrorNegocio.EXISTE_USUARIO_CON_MISMA_INDENTIFICACION.getMensaje(),
                    HttpStatus.OK);
        }else{
            ClienteEntity clienteEntity = modelMapper.map(clienteDto, ClienteEntity.class);
            ClienteEntity clienteGuardado = clienteRepository.save(clienteEntity);
            return modelMapper.map(clienteGuardado,ClienteDto.class);
        }
    }

    private Optional<ClienteEntity> consultarClientePorIdentificacion(String identificacion){
       return clienteRepository.findByIdentificacion(identificacion);
    }

    @Override
    public ClienteDto obtenerClientePorId(Integer idCliente) throws NeorisException {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(idCliente);
        if(clienteEntity.isPresent()){
            return modelMapper.map(clienteEntity.get(), ClienteDto.class);
        }else{
            throw new NeorisException(MensajesErrorNegocio.NO_EXISTE_USUARIO_CON_ESTE_ID.getMensaje() + idCliente ,
                    HttpStatus.OK);
        }
    }

    @Override
    public ClienteDto editarCliente(ClienteDto cliente) throws NeorisException {
        if(!ObjectUtils.isEmpty(cliente.getId())){
            Optional<ClienteEntity> clienteEntity = clienteRepository.findById(cliente.getId());
            if(clienteEntity.isPresent()){
                ClienteEntity clienteGuardado = clienteRepository.save(modelMapper.map(cliente, ClienteEntity.class));
                return modelMapper.map(clienteGuardado, ClienteDto.class);
            }else{
                throw new NeorisException(MensajesErrorNegocio.NO_EXISTE_USUARIO_CON_ESTE_ID.getMensaje() + cliente.getId(),
                        HttpStatus.OK);
            }
        }else{
            throw new NeorisException(MensajesErrorNegocio.ID_CLIENTE_NULL.getMensaje(),
                    HttpStatus.OK);
        }
    }

    @Override
    public ClienteDto actualizarCliente(Integer idCliente, ClientePatchDto cliente){
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(idCliente);
        if (clienteEntity.isPresent()) {
            MapClientePatchDtoToClienteEntity mapClientePatchDtoToClienteEntity = new MapClientePatchDtoToClienteEntity();
            mapClientePatchDtoToClienteEntity.mapClientePatchDtoToClienteEntity(cliente, clienteEntity.get());
            return modelMapper.map(clienteRepository.save(clienteEntity.get()), ClienteDto.class);
        } else {
            throw new NeorisException(MensajesErrorNegocio.NO_EXISTE_USUARIO_CON_ESTE_ID.getMensaje() + idCliente,
                    HttpStatus.OK);
        }
    }

    @Override
    public ClienteDto eliminarCliente(Integer idCliente){
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(idCliente);
        if(clienteEntity.isPresent()){
           clienteRepository.deleteById(idCliente);
           return modelMapper.map(clienteEntity.get(), ClienteDto.class);
        }else {
            throw new NeorisException(MensajesErrorNegocio.NO_EXISTE_USUARIO_CON_ESTE_ID.getMensaje() + idCliente,
                    HttpStatus.OK);
        }
    }

    @Override
    public List<ClienteDto> obtenerTodos(){
        List<ClienteEntity> clienteEntity = clienteRepository.findAll();

        if(clienteEntity.isEmpty()){
            throw new NeorisException(MensajesErrorNegocio.NO_HAY_DATOS.getMensaje(),
                    HttpStatus.OK);
        }else{
            List<ClienteDto> clienteDtoList = new ArrayList<>();
            for(ClienteEntity cliente : clienteEntity){
                ClienteDto clienteDto = convertirClienteEntityADto(cliente);
                clienteDtoList.add(clienteDto);
            }
            return clienteDtoList;
        }
    }

    private ClienteDto convertirClienteEntityADto(ClienteEntity clienteEntity) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(clienteEntity.getId());
        clienteDto.setEstado(clienteEntity.getEstado());

        PersonaDto perDto = new PersonaDto();
        perDto.setTelefono(clienteEntity.getPersona().getTelefono());
        perDto.setId(clienteEntity.getPersona().getId());
        perDto.setDireccion(clienteEntity.getPersona().getDireccion());
        perDto.setGenero(clienteEntity.getPersona().getGenero());
        perDto.setEdad(clienteEntity.getPersona().getEdad());
        perDto.setIdentificacion(clienteEntity.getPersona().getIdentificacion());
        perDto.setNombre(clienteEntity.getPersona().getNombre());
        clienteDto.setPersona(perDto);
        return clienteDto;
    }


}
