import { Component, OnInit, OnDestroy } from '@angular/core';
 
import { ClientDetails } from './client';
import { ClientService } from './client.service';
import { ActivatedRoute, Router } from '@angular/router';
 
 
@Component({
  selector: 'app-personedit',
  templateUrl: './ClientEdit.html',
  styles: []
})
export class ClientEdit implements OnInit, OnDestroy {
  cd: ClientDetails;
  sub: any;
  errorMessage: string = '';
  response: any;
 
 
  constructor(private ps: ClientService,
    private route: ActivatedRoute,
    private router: Router) { }
 
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let id = Number.parseInt(params['clientIndex']);
      console.log('getting client with clientIndex: ' + clientIndex);
      this.ps
        .get(clientIndex)
        .subscribe(p => this.client = p);
    });
  }
 
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
 
  saveClientDetails() {
    this.cs.save(this.client).subscribe(p => this.response = p,
                                                        e => this.errorMessage = e._body,
                                                        () => this.router.navigate(['/client/', this.client.clientIndex]));
  }
}