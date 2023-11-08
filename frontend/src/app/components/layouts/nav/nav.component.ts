import { Component, HostListener } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {
  name = ""
  navtool = ""
  clickMessage = '';
  sut = {
    "padding": "0"
  };
  currentPath = ""
  emtyPath = ""
  navbarStatus=""
  @HostListener('document:click', ['$event'])
  onDocumentClick(event: MouseEvent) {
    // Check if the click event target is not the button
    if (!(event.target as HTMLElement).matches('button')) {
      this.sut.padding = '0px';
      this.clickMessage = '';
    }
  }
  constructor(private router: Router) {

    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        // You can access the current path here
        this.currentPath = event.url;
        this.navtool = ''
        // console.log('Current Path:', this.currentPath);
        // console.log('Current navtool:', this.navtool);
        if (event.url !== "/messages" ){
          this.navbarStatus="navbar-big"
        }else{
          this.navbarStatus="navbar-small"
        }
      }
    });

    this.clickMessage = '';
    this.sut.padding = '0px';

  }
  onClickMe() {
    if (this.sut.padding === '0px' && this.clickMessage === '') {
      this.clickMessage = 'You are my hero!';
      this.sut.padding = '30px';
    } else {
      this.clickMessage = '';
      this.sut.padding = '0px';
    }
  }
  onClickChange() {


    // if (this.svg_line.display === 'block' && this.svg_weight.display==='none') {
    //   console.log("hiii")
    //   this.svg_line.display = 'none';
    //   this.svg_weight.display='block';
    // } else if (this.svg_line.display === 'none' && this.svg_weight.display ==='block'){
    //   console.log("haaa")
    //   this.svg_line.display = 'block';
    //   this.svg_weight.display='none';
    // }
  }
  // onChangeName(event:any){
  //   this.name=event.target.value
  // }

  logData(data: string | null) {
 
     if (data===this.emtyPath ){
      if (data!=='/messages'){
        this.navbarStatus = "navbar-big"
      }
      this.currentPath = this.emtyPath
    
      this.navtool = ''
 
    }
     else if (data !== null && this.navtool!=data ) {
      this.navtool = ''
      this.navtool = data
      if (this.currentPath !== "") {
        this.emtyPath = this.currentPath
      }
      if (data==="note"||data==="search" ){
        this.navbarStatus ="navbar-small"
      }
      else{
        this.navbarStatus = "navbar-big"
      }
      this.currentPath = ''
    }
  
  else{
    this.navtool = ''
    this.currentPath = this.emtyPath
    if (this.currentPath!=='/messages'){
      this.navbarStatus = "navbar-big"
    }
 
  }
  }

}
