import { Component, OnInit } from '@angular/core';

import { NeService }  from '../neservice';
import { ValuesForControls }  from '../valuesforcontrols';

@Component({
  selector: 'source-selector',
  styleUrls: ['./source-selector.component.css'],
  template: `
        <datalist id="sources">
           <option *ngFor="let x of valuesForControls?.sources">{{x}}</option>
        </datalist>`
})
export class SourceSelectorComponent implements OnInit {

  valuesForControls: ValuesForControls;

  constructor(private neService: NeService) { 
  }

  ngOnInit() {
     this.neService.getValuesForControls().subscribe(r=> this.valuesForControls = r);
  }

}