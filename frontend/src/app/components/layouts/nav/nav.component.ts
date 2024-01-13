import { Component, HostListener } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {
  name :string
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
    if (!(event.target as HTMLElement).matches('button')) {
      this.sut.padding = '0px';
      this.clickMessage = '';
    
    }
    if (!(event.target as HTMLElement).matches('nav')) {
   
    
    }
  }
  constructor(private router: Router) {
    this.name=""
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.currentPath = event.url;
        this.navtool = ''
   
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
  }

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
