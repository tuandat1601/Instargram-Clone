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
  listOfString :string [] = ["ngoc", "dat"]
 products:Product[] = [
  {
    name:"hi",
  },
  {
    name:"hi",
  }
 ]
}
