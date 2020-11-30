import { DarkModeService } from './../services/darkmode.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})

export class MainComponent {
    theme:string = 'lite';

    constructor(private darkModeService: DarkModeService) {
      this.darkModeService.switchDarkMode.subscribe(
        (newStatus: string) => {this.theme = newStatus}
      );
     }

  ngOnInit() {
  }
}
