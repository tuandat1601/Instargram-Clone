import { Component } from '@angular/core';
type Product ={
  name:string
}
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent {
  
 products:Product[] = [
  {
    name:"hi",
  },
  {
    name:"hi",
  }
 ]
}
