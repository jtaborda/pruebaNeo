import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'testNeorisFront';
  tipoSeleccion: number | undefined;
  
  constructor() {};

  ngOnInit(): void {};

  seleccion(value: number)
  {
    this.tipoSeleccion=value;
  }
}
