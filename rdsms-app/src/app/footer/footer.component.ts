import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  public companyName = 'Nitesh Rajput';
  public accessRights = 'Copyright © 2018 RD Service. All Rights Reserved';
  constructor() { }

  ngOnInit() {
  }

}
