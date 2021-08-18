import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { from } from "rxjs";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html'
})
export class LoginComponent {

    constructor(private http:HttpClient,private router:Router){}

    email = "";

    onSubmit(form:NgForm){
        console.log(form);
        this.http.post('http://localhost:8070/payback/login',
            JSON.stringify({id:form.value.id,email:form.value.email,password:form.value.password}))
            .subscribe({
                next: (data:any)=>{
                    this.email = data.email;

                    if(data.status === 'success') {
                        //this is just saving it form the form into local storage not from the database
                        localStorage.setItem("user_id", form.value.id);
                        localStorage.setItem("email", form.value.email);
                    }
                    
                    this.router.navigate([''])
                }
            })
    }

}