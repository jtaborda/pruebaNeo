import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ClientTableRow } from 'src/dto/Cliente.types';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef, MatDialogModule} from '@angular/material/dialog';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { from } from 'rxjs';
import { ClienteService } from 'src/app/Services/cliente.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-create-update-cliente',
  templateUrl: './create-update-cliente.component.html',
  styleUrls: ['./create-update-cliente.component.css']
})
export class CreateUpdateClienteComponent implements OnInit {
  [x: string]: any;
  @Output() close = new EventEmitter<boolean>();
  @Input() element!: ClientTableRow;
  itemForm!: FormGroup;
  textCreaEdit:string ="Crear Cliente"
  constructor(public dialog: MatDialog,  private ClienteService : ClienteService, 
    private FormBuilder: FormBuilder,private snackBar: MatSnackBar) {
    this.itemForm = this.FormBuilder.group({
      nombre: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(55)]],
      genero: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(55)]],
      edad: ['', [Validators.required]],
      identificacion: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(10)]],
      direccion: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(55)]],
      telefono: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(10)]],
      contrasena: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(55)]],
      estado: ['', [Validators.required]]
    });
  }
crea:number=0;
  ngOnInit(): void {
console.log(this.element)
  if(this.element?.insertOrEdit==1){
    this.textCreaEdit='Edita Cliente';
     this.itemForm.controls['nombre'].setValue(this.element.nombre);
     this.itemForm.controls['genero'].setValue(this.element.genero);
     this.itemForm.controls['edad'].setValue(this.element.edad);
     this.itemForm.controls['identificacion'].setValue(this.element.identificacion);
     this.itemForm.controls['direccion'].setValue(this.element.direccion);
     this.itemForm.controls['telefono'].setValue(this.element.telefono);
      this.itemForm.controls['contrasena'].setValue(this.element.contrasena);
      this.itemForm.controls['estado'].setValue(this.element.estado);
      this.crea=0;
}
else
{
  this.crea=1;
}


  }

  openDialog(): void {
  }


  closeModal(): void {
    this.close.emit(false);
  }


  create()
  {
   let data={
      persona: {
          nombre: this.itemForm.controls['nombre'].value,
          genero: this.itemForm.controls['genero'].value,
          edad: this.itemForm.controls['edad'].value,
          identificacion: this.itemForm.controls['identificacion'].value,
          direccion: this.itemForm.controls['direccion'].value,
          telefono: this.itemForm.controls['telefono'].value,
      },
      contrasena: this.itemForm.controls['contrasena'].value,
      estado: true
     } 

   this.ClienteService.create(data).subscribe((data:any)=>{
    this.showAlert();
       })
  }



  update()
  {
   let data={
      persona: {
          nombre: this.itemForm.controls['nombre'].value,
          genero: this.itemForm.controls['genero'].value,
          edad: this.itemForm.controls['edad'].value,
          identificacion: this.itemForm.controls['identificacion'].value,
          direccion: this.itemForm.controls['direccion'].value,
          telefono: this.itemForm.controls['telefono'].value,
      },
      contrasena: this.itemForm.controls['contrasena'].value,
      estado: true,
      id:this.element.id
     } 

   this.ClienteService.update(data).subscribe((data:any)=>{
    this.showAlert();
       })
  }


  showAlert() {
    this.snackBar.open('Confirmacion!', 'Cerrar', {
      duration: 3000, // Duración en milisegundos
    
    });
    this.closeModal();
  }

}
