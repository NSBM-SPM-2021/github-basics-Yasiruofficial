import { Injectable } from '@angular/core';
import jwt_decode from "jwt-decode";

const ACCESS_TOKEN = 'access_token';
// const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
  constructor() { }

  signOut(): void {
    window.sessionStorage.clear();
  }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem(ACCESS_TOKEN);
    window.sessionStorage.setItem(ACCESS_TOKEN, token);
  }

  public getToken(): string | null {
    return window.sessionStorage.getItem(ACCESS_TOKEN);
  }

  public getRoles(): any {
    const key = window.sessionStorage.getItem(ACCESS_TOKEN);
    let decoded : string = jwt_decode(key as string);

    return JSON.parse(JSON.stringify(decoded)).roles;
  }
}
