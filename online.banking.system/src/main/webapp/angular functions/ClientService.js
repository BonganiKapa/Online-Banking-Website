import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { ClientDetailBean } from './person';
import 'rxjs/add/operator/map';
 
@Injectable()
export class ClientService {
  private baseUrl: string = 'http://localhost:8080/SWBackend/jaxrs';
 
  constructor(private http: Http) {
  }
 
  get(id: number): Observable<ClientDetailBean> {
    let client$ = this.http
      .get(`${this.baseUrl}/ClientDetailBean/${id}`, {headers: this.getHeaders()})
      .map(mapClients);
      return client$;
  }
 
  getAll(): Observable<ClientDetailBean[]> {
     let client$ = this.http
      .get(`${this.baseUrl}/ClientDetailBean`, {headers: this.getHeaders()})
      .map(mapClients);
    return client$;
  }
 
  save(client: ClientDetailBean): Observable<Response> {
    console.log('Saving client ' + JSON.stringify(client));
    return this.http.put(`${this.baseUrl}/ClientDetailBean`, JSON.stringify(client), {headers: this.getHeaders()});
  }
 
  private getHeaders() {
    let headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');
    return headers;
  }
}
 
function mapClients(response: Response): ClientDetailBean[] {
  return response.json().map(toClient);
}
 
function mapClient(response: Response): ClientDetailBean {
  return toClient(response.json());
}
 
function toClient(r: any): ClientDetailBean {
  return r;
}