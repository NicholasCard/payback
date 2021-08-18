import { Component, Input, SimpleChanges } from '@angular/core';

import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
    selector: 'ticketHeader',
    templateUrl: './header.html'
  })
  export class TicketHeader {
    title = 'Ticket';
    
    reqdata = '';
    email = '';

  constructor(private http:HttpClient, private router:Router) {}

  ngOnInit() {      
    this.http.post("http://localhost:8070/payback/user", JSON.stringify({email:"nickcard@email.com",id:1}))
    .subscribe({
      next:(data:any)=>{
        console.log(data);
        this.email = data.email;
      },
      error:(error)=>{},
      complete:()=>{}
    })
  }

    pconsole(g: any){
      console.log(g);
    }

  }