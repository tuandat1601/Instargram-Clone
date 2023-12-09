import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';

import { ExploreComponent } from './components/pages/explore/explore.component';

import { MessagesComponent } from './components/pages/messages/messages.component';
import { ReelsComponent } from './components/pages/reels/reels.component';


const routes: Routes = [
  
    { path: '', component: HomeComponent },
   
    { path: 'explore', component: ExploreComponent },
    { path: 'reels', component:ReelsComponent},
    { path: 'messages', component:MessagesComponent },
   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
