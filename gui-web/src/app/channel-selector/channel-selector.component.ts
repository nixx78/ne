import { Component, OnInit } from '@angular/core';

import { NeService }  from '../neservice';
import { ValuesForControls }  from '../valuesforcontrols';

@Component({
  selector: 'channel-selector',
  styleUrls: ['./channel-selector.component.css'],
  template: `
        <datalist id="channels">
           <option *ngFor="let x of valuesForControls?.channels">{{x}}</option>
        </datalist>`
})
export class ChannelSelectorComponent implements OnInit {

  valuesForControls: ValuesForControls;

  constructor(private neService: NeService) { 
  }

  ngOnInit() {
     this.neService.getValuesForControls().subscribe(r=> this.valuesForControls = r);
  }

}
