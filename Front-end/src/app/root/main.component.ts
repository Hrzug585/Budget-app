import { DarkModeService } from './../services/darkmode.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})

export class MainComponent {
    darkMode:boolean = true;

    constructor(private darkModeService: DarkModeService) {
      this.darkModeService.switchDarkMode.subscribe(
        (newStatus: boolean) => {this.darkMode = newStatus}
      );
     }

  ngOnInit() {
  }
}
