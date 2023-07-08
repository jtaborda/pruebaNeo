import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ClienteService } from 'src/app/Services/cliente.service';
import { ClientTableRow } from 'src/dto/Cliente.types';
import { ACTIONS } from 'src/interfaces/insert-edit-type';
import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})


export class ClientesComponent implements OnInit{

  
  constructor( private ClienteService : ClienteService,private snackBar: MatSnackBar) {};
  displayedColumns: string[] = ['id', 'Nombre', 'Genero', 'Edad','identificacion', 'Direccion', 'Telefono','Editar','Eliminar'];

  ngOnInit(): void {
    this.callGetAll();
  };

  dataSource: any;
  criteries: string = "";
  listData: any;
  listFusion: any[]=[];
  copiaGetAll: any[]=[];
  inputCriterio!: string;
  modalCliente:boolean=false;
  element!: ClientTableRow;
  llamarAgregar(value:number){
    if(value==1)
    {
     this.modalCliente=true;
    }



  }
  callGetAll(){
    this.listFusion=[];
    this.ClienteService.getAll().subscribe((data:any)=>{
    let dato= data.objetoRespuesta.listObjetoRespuestaDto.forEach((ele: any) => {
      let persona={
        id:ele.id,
        nombre: ele.persona.nombre,
        genero: ele.persona.genero,
        edad: ele.persona.edad,
        identificacion: ele.persona.identificacion,
        direccion: ele.persona.direccion,
        telefono: ele.persona.telefono,
        contrasena: ele.persona.contrasena,
        estado: ele.persona.estado,
      }
      this.listFusion.push(persona)
    });
        this.dataSource= this.listFusion;
        this.copiaGetAll= this.listFusion;        
    }

    )}
    filterCritery(filterValue: any) {
      let criterio: string = filterValue?.target?.value;
      filterValue = filterValue?.target?.value;
      let list = ['nombre', 'genero', 'direccion', 'telefono'];
      if (criterio?.length > 2) {
        this.criteries = criterio;
        this.listData = [];
        this.listData =this.copiaGetAll;
        this.listData = this.listData.filter((data:any) => {
          let otherValue = false;
          for (let i of list) {
            const element = i;
            otherValue =
              data[element]?.toLowerCase().indexOf(filterValue.toLowerCase()) > -1 ||
              otherValue;
          }
          return otherValue;
        });
        this.dataSource=this.listData;
      } else {
        if (criterio?.length < 1) {
          this.criteries = "";
          this.callGetAll();
        }
      }
    }    

    eliminar(element:any)
    {
      this.ClienteService.delete(element.id).subscribe((data:any)=>{
        this.showAlert()
        this.callGetAll();
        })
    }

    editar(element:any)
    {
      this.element = {
        insertOrEdit: ACTIONS.EDIT,
        id : element.id,
        nombre:element.nombre,
        genero: element.genero,
        edad: element.edad,
        identificacion: element.identificacion,
        direccion: element.direccion,
        telefono: element.telefono,
        contrasena: "123",
        estado: true,

      };
      this.modalCliente = true;
    }
 

    openModal(isModalOpen: boolean) {
      this.element = {
        insertOrEdit: ACTIONS.INSERT,
        id : 0,
        nombre:"",
        genero: "",
        edad: 0,
        identificacion: "",
        direccion: "",
        telefono: 0,
        contrasena: "",
        estado: false

      };
      if (!isModalOpen) {
        this.callGetAll();
      }
      this.modalCliente = isModalOpen;
    }

    
  showAlert() {
    this.snackBar.open('Dato Eliminado!', 'Cerrar', {
      duration: 3000, // Duración en milisegundos
    
    });

  }


}
