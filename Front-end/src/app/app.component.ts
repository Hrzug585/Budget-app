import { DarkModeService } from './services/darkmode.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.compoment.html',
  styles: []
})
export class AppComponent {
  title = 'Front-end';
  darkMode:boolean = true;


  constructor(private darkModeService: DarkModeService) {
    this.darkModeService.switchDarkMode.subscribe(
      (newStatus: boolean) => {this.darkMode = newStatus}
    );
   }

  ngOnInit() {
  }
}
