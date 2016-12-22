import { Component, OnInit } from '@angular/core';

import { NeService} from '../neservice';
import { Message} from '../message';

@Component({
  selector: 'app-message-browser',
  templateUrl: './message-browser.component.html',
  styleUrls: ['./message-browser.component.css']
})

export class MessageBrowserComponent implements OnInit {

  messages: Message[] = [];
  selectedMessage: Message = new Message();

  constructor(private neService: NeService) { 
    this.selectedMessage = new Message();
  }

  ngOnInit() {
    this.neService.getAllMessages().subscribe(messages => {this.messages = messages; this.onSelect(this.messages[0]);});
  }

  onSelect(message:Message) :void {
  	this.selectedMessage = message;
  }


}
