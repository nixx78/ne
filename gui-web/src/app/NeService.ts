import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';
import { environment } from '../environments/environment';

import 'rxjs/add/operator/toPromise';

import { InMessage } from './inmessage';

@Injectable()
export class NeService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private neRestUrl = environment.rest_api;
  
  constructor(private http: Http) { }

  sendMessage(inMessage: InMessage): Promise<null> {
    const url = `${this.neRestUrl}/inbound`;
    return this.http
      .post(url, JSON.stringify(inMessage), {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }
 
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
  
}
