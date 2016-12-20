import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PostMessageComponent } from './post-message/post-message.component';
import { MessageBrowserComponent } from './message-browser/message-browser.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    PostMessageComponent,
    MessageBrowserComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
