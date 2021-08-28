import {HttpHeaders} from "@angular/common/http";


export const HOST:string = "http://localhost:9001/api/";

export const httpOptions_Global = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};

