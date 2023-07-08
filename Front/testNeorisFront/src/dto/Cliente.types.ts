import { ACTIONS } from "src/interfaces/insert-edit-type";


export class ClientTableRow {

  insertOrEdit!: ACTIONS;
  id : number| undefined;
  nombre: string| undefined;
  genero: string| undefined;
  edad: number| undefined;
  identificacion: string| undefined;
  direccion: string| undefined;
  telefono: number| undefined;
  contrasena: string| undefined;
  estado: boolean | undefined;


}
