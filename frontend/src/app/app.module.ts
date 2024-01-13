import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/pages/home/home.component';
import { NavComponent } from './components/layouts/nav/nav.component';
import { ExploreComponent } from './components/pages/explore/explore.component';


import { MessagesComponent } from './components/pages/messages/messages.component';
import { CreateComponent } from './components/pages/create/create.component';
import { FormsModule } from '@angular/forms';
import { ReelsComponent } from './components/pages/reels/reels.component';
import { PostsComponent } from './components/pages/home/posts/posts.component';
import { SearchComponent } from './components/layouts/search/search.component';

import { SuggestedComponent } from './components/pages/home/suggested/suggested.component';
import { PostComponent } from './components/pages/home/posts/post/post.component';
import { NotificationComponent } from './components/layouts/notification/notification.component';
import { CreatepostComponent } from './components/layouts/createpost/createpost.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavComponent,
    ExploreComponent,
    SearchComponent,
   
    MessagesComponent,
    CreateComponent,
    ReelsComponent,
    PostsComponent,
    SuggestedComponent,
    PostComponent,
    NotificationComponent,
    CreatepostComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
