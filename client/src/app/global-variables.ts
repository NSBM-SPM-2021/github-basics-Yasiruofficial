import {HttpHeaders} from "@angular/common/http";


export const HOST:string = "http://54.234.239.91:9001/api/";

export const httpOptions_Global = {
  headers: new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' })
};

