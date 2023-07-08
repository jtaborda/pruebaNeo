import { Component, OnInit } from '@angular/core';
import {  FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ClienteService } from 'src/app/Services/cliente.service';
import { MovimientoService } from 'src/app/Services/movimientos.service';
import { format } from 'date-fns';
import { ViewChild, ElementRef } from '@angular/core';
import  'jspdf';
import 'jspdf-autotable';
declare var jsPDF: any;


@Component({
  selector: 'app-reportes',
  templateUrl: './reportes.component.html',
  styleUrls: ['./reportes.component.css']
})
export class ReportesComponent implements OnInit {
  @ViewChild('tablaDatos')
  tablaDatos!: ElementRef;

  listClientes: Array<any> = [];
  itemForm!: FormGroup;
  dataSource: any;
  criteries: string = "";
  listData: any;
  listFusion: any[]=[];
  copiaGetAll: any[]=[];
  inputCriterio!: string;
  public typeIdSel = 0;


  constructor( private FormBuilder: FormBuilder,private ClienteService : ClienteService  ,private movimientoService : MovimientoService ) {
    this.itemForm = this.FormBuilder.group({
      fInicial: ['', [Validators.required]],
      fFinal: ['', [Validators.required]],
      clieneId: ['', [Validators.required]],
    });
  }
  displayedColumns: string[] = ['Fecha', 'Nombre', 'Numero', 'Tipo','Inicial', 'Movimiento', 'Saldo'];

  callGetAll(){
    this.listClientes=[];
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

      this.listClientes.push(persona)
    });
     
    }

    )}

    myDate = new Date();
    generarReop(){

      let data=format(this.itemForm.controls['fInicial'].value, 'yyyy-MM-dd');
      let dataF=format(this.itemForm.controls['fFinal'].value, 'yyyy-MM-dd');
      let id=this.itemForm.controls['clieneId'].value;   
      this.movimientoService.getReporte(data,dataF,id).subscribe((data:any)=>{
      
      let dato= data.objetoRespuesta.listObjetoRespuestaDto.forEach((ele: any) => {
        this.listFusion.push(ele)
      });
          this.dataSource= this.listFusion;
          this.copiaGetAll= this.listFusion;        
         })
    }

    obtenerFechaFormateada() {
      return format(this.itemForm.controls['fInicial'].value, 'yyyy-MM-dd');
    }

  ngOnInit(): void {
    this.callGetAll();
  }

  exportarAPDF() {
    let doc = new jsPDF();
    var item = this.dataSource;
    var rows = [];

    for (var key in item) {
      var temp = [key, item[key]];
      rows.push(temp);
    }
  
     doc.autoTable(this.displayedColumns, rows);

     doc.save('FirstPdf.pdf');


   
    //doc.save('Test.pdf');
  }
  


}
