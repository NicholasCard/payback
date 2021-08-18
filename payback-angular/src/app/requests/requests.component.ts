import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.css']
})
export class RequestsComponent implements OnInit {

  description:string = ''

  requests:any = []

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.fetchRequests()
  }

  fetchRequests(){
    this.http.post('http://localhost:8070/payback/requests',
    JSON.stringify({id:localStorage.getItem("user_id")}))
    .subscribe({
      next: (data) => {
        console.log(data)
       
        this.requests = data
        console.log("this is the requests right here ")
        console.log(this.requests)
      }
    })
  }
/*
  onTitleChange(e:any){
    this.description = e.target.value
  }
save this for later for adding a new request
  submitMenu(){
    console.log('adding menu..');
    
    this.http.post('http://localhost:8070/payback/requests',JSON.stringify({title:this.title})).subscribe({
      next: (data)=>{
        this.fetchMenus()
      }
    })
  }
*/
}
