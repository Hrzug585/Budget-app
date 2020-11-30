import { DarkModeService } from './../../services/darkmode.service';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component-light.css'],
  providers: []
})
export class HeaderComponent implements OnInit {
  theme:string = 'lite';

  constructor(private darkModeService: DarkModeService) {
    this.darkModeService.switchDarkMode.subscribe(
      (newStatus: string) => {this.theme = newStatus}
    );
   }

  ngOnInit(): void {
  }

  onModeSwitch() {
    this.darkModeService.onUpdate(this.theme);
    // this.darkMode = !this.darkMode;
    // console.log(this.darkMode);
  }

}
