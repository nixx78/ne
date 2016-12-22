import { Injectable }    from '@angular/core';
import { Http, Response, Headers } from '@angular/http';

import { Observable }    from 'rxjs';
import { environment } from '../environments/environment';

import 'rxjs/add/operator/toPromise';

import { InMessage } from './inmessage';
import { Message } from './message';
import { MessageResponse } from './messageresponse';
import { ValuesForControls }  from './valuesforcontrols';

@Injectable()
export class NeService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private neRestUrl = environment.rest_api;
  
  constructor(private http: Http) { }

  sendMessage(inMessage: InMessage): Observable<MessageResponse> {
    const url = `${this.neRestUrl}/inbound`;
    return this.http
      .post(url, JSON.stringify(inMessage), {headers: this.headers})
      .map((res:Response) => res.json() as MessageResponse)
      .catch(this.handleError);
  }

  getAllMessages(): Observable<Message[]> {
    const url = `${this.neRestUrl}/statistic/messages`;
    return this.http.get(url)
      .map((res:Response) => res.json() as Message[])
      .catch(this.handleError);
  }

  getValuesForControls(): Observable<ValuesForControls> {
    const url = `${this.neRestUrl}/statistic/values_for_controls`;
    return this.http.get(url)
        .map((res:Response) => res.json() as ValuesForControls[])
        .catch(this.handleError);
  }


  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
  
}
