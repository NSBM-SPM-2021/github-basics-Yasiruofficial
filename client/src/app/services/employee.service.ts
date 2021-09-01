import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

import {HOST,httpOptions_Global} from "../global-variables";

const API_URL = HOST;
const HEADER_OPTION = httpOptions_Global;


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {


  isNotEmpty(value: any): boolean {
    return value !== undefined && value !== null && value !== "";
  }

  constructor(private httpClient: HttpClient) {
  }

  load(loadOptions: any) {

    let params: HttpParams = new HttpParams();

    [
      "skip",
      "take",
      "requireTotalCount",
      "requireGroupCount",
      "sort",
      "filter",
      "totalSummary",
      "group",
      "groupSummary"
    ].forEach((i) => {
      if (i in loadOptions && this.isNotEmpty(loadOptions[i]))
        params = params.set(i, JSON.stringify(loadOptions[i]));
    });
    return this.httpClient.get(API_URL + encodeURIComponent("employees"), {params: params})
      .toPromise()
      .then((data: any) => {
        return {
          data: data.data,
          totalCount: data.totalCount,
          summary: data.summary,
          groupCount: data.groupCount
        };
      })
      .catch(error => {
        if(error.status === 403){
          throw 'You are Unauthorized to READ employees'
        }
        throw 'Data Loading Error'
      });
  }

  insert(values: any) {

    return this.httpClient.post(API_URL + encodeURIComponent("employees"), values)
      .toPromise()
      .then()
      .catch(error => {
        if(error.status === 403){
          throw 'You are Unauthorized to ADD employees'
        }
        throw 'Data Adding Error'
      })
  }

  update(key: string, values: any) {
    return this.httpClient.put(API_URL +"employees/" + key, values)
      .toPromise()
      .then()
      .catch((error => {
        if(error.status === 403){
          throw 'You are Unauthorized to EDIT employees'
        }
        throw 'Data Editing Error'
      }))
  }

  remove(key: string) {
    return this.httpClient.delete(API_URL + "employees/"+key)
      .toPromise()
      .then()
      .catch((error => {
        if(error.status === 403){
          throw 'You are Unauthorized to DELETE employees'
        }
        throw 'Data Romove Error'
      }))
  }

}
