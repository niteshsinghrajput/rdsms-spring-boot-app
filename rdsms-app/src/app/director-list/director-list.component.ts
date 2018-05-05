import { Component, OnInit } from '@angular/core';
import { IDirector } from '../director';
import { DirectorService } from '../director.service';

@Component({
  selector: 'app-director-list',
  templateUrl: './director-list.component.html',
  styleUrls: ['./director-list.component.css'],
  providers: [DirectorService]
})
export class DirectorListComponent implements OnInit {

  directors: IDirector[];

  constructor(private directorService: DirectorService) { }

  ngOnInit() {
    console.log('Getting list of directors from director service...');
    this.directorService.getDirectors().subscribe(data => this.directors = data);
  }


}
