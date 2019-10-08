import { Component, OnInit } from '@angular/core';
import { ClientService } from './client.service';
import { Person } from './client';
 
 
@Component({
  selector: 'app-clientlist',
  templateUrl: './clientlist.html',
  styles: []
})
 
export class ClientListComponent implements OnInit {
  clntBean: ClientDetailBean[] = [];
 
  constructor(private cs: ClientService) { }
 
  ngOnInit() {
    this.cs.getAll().subscribe(p => this.client = clnt);
  }
 
}