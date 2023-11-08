import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/pages/home/home.component';
import { NavComponent } from './components/layouts/nav/nav.component';
import { ExploreComponent } from './components/pages/explore/explore.component';
import { SearchComponent } from './components/pages/search/search.component';
import { NotificationsComponent } from './components/pages/notifications/notifications.component';
import { MessagesComponent } from './components/pages/messages/messages.component';
import { CreateComponent } from './components/pages/create/create.component';
import { FormsModule } from '@angular/forms';
import { ReelsComponent } from './components/pages/reels/reels.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavComponent,
    ExploreComponent,
    SearchComponent,
    NotificationsComponent,
    MessagesComponent,
    CreateComponent,
    ReelsComponent
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
