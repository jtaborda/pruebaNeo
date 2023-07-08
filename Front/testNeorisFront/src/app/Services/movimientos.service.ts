import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';


@Injectable({
 providedIn: 'root'
})
export class MovimientoService {

    private url :string ="http://localhost:8080/api/movimientos/"
    constructor(private http:HttpClient) { }
   
    //obtiene el listado de  =
    getReporte(data:any,dataF:any,id:Number):Observable<any>{
      return this.http.get<any>(this.url+data+'/'+dataF+'/'+id);
    }
   
//Crea un 
     create(data:any):Observable<any>
     {
       return this.http.post<any>(this.url,data);
     }

     //Modifica 
     update(data:any):Observable<any>
     {
       return this.http.put<any>(this.url,data);
     }

      //delete un empleado
     delete(id : number):Observable<any>
      {
       return this.http.delete<any>(this.url+id);
      }
}