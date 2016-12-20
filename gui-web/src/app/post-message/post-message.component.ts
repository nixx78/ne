import { Component, OnInit } from '@angular/core';
import { InMessage }  from '../inmessage';
import { NeService }  from '../neservice';


@Component({
  selector: 'app-post-message',
  templateUrl: './post-message.component.html',
  styleUrls: ['./post-message.component.css']
})

export class PostMessageComponent implements OnInit {

  message: InMessage = new InMessage();
    
  constructor(private neService: NeService) { 
  }

  ngOnInit() {
      this.message.channel = 'channel1';
      this.message.body = 'message body123';
      this.message.senderId = 'sender_reference';
  }

  sendMessage() {
    this.neService.sendMessage(this.message);
  }


}
