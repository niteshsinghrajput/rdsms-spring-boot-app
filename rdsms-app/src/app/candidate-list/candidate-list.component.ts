import { Component, OnInit } from '@angular/core';
import { CandidateService } from '../candidate.service';
import { ICandidate } from '../candidate';

@Component({
  selector: 'app-candidate-list',
  templateUrl: './candidate-list.component.html',
  styleUrls: ['./candidate-list.component.css'],
  providers: [CandidateService]
})
export class CandidateListComponent implements OnInit {

  public candidates = [];
  constructor(private candidateService: CandidateService) { }

  ngOnInit() {
      console.log('Getting candidates from candidateService...');
      this.candidateService.getCandidates().subscribe(data => this.candidates = data);
  }

}
