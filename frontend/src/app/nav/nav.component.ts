import { Component, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { async } from 'rxjs';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  svg_line={
    "display": "block"
  }
  svg_weight={
    "display":"none"
  }
  @HostListener('document:click', ['$event'])
  onDocumentClick(event: MouseEvent) {
    // Check if the click event target is not the button
    if (!(event.target as HTMLElement).matches('button')) {
      this.sut.padding = '0px';
      this.clickMessage = '';
    }
  }
  clickMessage = '';
sut ={
"padding":"0"};

constructor(private router: Router) {
  
  
  this.clickMessage = '';
  this.sut.padding = '0px';
  this.svg_line.display='block';
  this.svg_weight.display='none';
}
  onClickMe() {
    if (this.sut.padding === '0px' &&this.clickMessage === '') {
      this.clickMessage = 'You are my hero!';
      this.sut.padding = '30px';
    } else {
      this.clickMessage = '';
      this.sut.padding = '0px';
    }
  }
 onClickChange () {
    
    const currentUrl = this.router.url;
    console.log('Current Route URL:', currentUrl);
    if (this.svg_line.display === 'block' && this.svg_weight.display==='none') {
      console.log("hiii")
      this.svg_line.display = 'none';
      this.svg_weight.display='block';
    } else if (this.svg_line.display === 'none' && this.svg_weight.display ==='block'){
      console.log("haaa")
      this.svg_line.display = 'block';
      this.svg_weight.display='none';
    }
  }
  
}
