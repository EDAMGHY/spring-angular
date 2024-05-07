import {Component, OnInit} from '@angular/core';
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-admin-temp',
  templateUrl: './admin-temp.component.html'
})
export class AdminTempComponent implements OnInit {

  constructor(public authService: AuthService) {
  }

  ngOnInit() {

  }

  logout() {
    this.authService.logout()
  }
}
