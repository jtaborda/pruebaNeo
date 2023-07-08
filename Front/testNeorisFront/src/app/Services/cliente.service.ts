import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';


@Injectable({
 providedIn: 'root'
})
export class ClienteService {

    private url :string ="http://localhost:8080/api/clientes/"
    constructor(private http:HttpClient) { }
   
    //obtiene el listado de  =
    getAll():Observable<any>{
      return this.http.get<any>(this.url);
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