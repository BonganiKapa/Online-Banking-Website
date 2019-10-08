import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientDetails } from './client';
import { ClientService } from './client';
 
@Component({
  selector: 'app-persondetail',
  templateUrl: './persondetail.component.html',
  styles: []
})
export class ClientDetailsDisplay implements OnInit, OnDestroy {
  client: ClientDetails;
  sub: any;
 
  constructor(private cs: ClientService,
    private route: ActivatedRoute,
    private router: Router) { }
 
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let index = Number.parseInt(params['clientIndex']);
      this.cs
        .get(index)
        .subscribe(clnt => this.client = clnt);
    });
  }
 
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
 
  gotoEdit() {
    this.router.navigate(['/client/edit', this.clientsss.clientIndex]);
  }
 
}