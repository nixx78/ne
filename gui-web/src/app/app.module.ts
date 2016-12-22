import './rxjs-extensions';
                           
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PostMessageComponent } from './post-message/post-message.component';
import { MessageBrowserComponent } from './message-browser/message-browser.component';

import { NeService } from './neservice';
import { ChannelSelectorComponent } from './channel-selector/channel-selector.component';
import { SourceSelectorComponent } from './source-selector/source-selector.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    PostMessageComponent,
    MessageBrowserComponent,
    ChannelSelectorComponent,
    SourceSelectorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [NeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
