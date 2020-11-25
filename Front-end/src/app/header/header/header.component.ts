import { DarkModeService } from './../../services/darkmode.service';
import { Component, EventEmitter, OnInit } from '@angular/core';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component-light.css'],
  providers: []
})
export class HeaderComponent implements OnInit {
  darkMode:boolean = true;

  constructor(private darkModeService: DarkModeService) {
    this.darkModeService.switchDarkMode.subscribe(
      (newStatus: boolean) => {this.darkMode = newStatus}
    );
   }

  ngOnInit(): void {
  }

  onModeSwitch() {
    this.darkModeService.onUpdate(!this.darkMode);
    // this.darkMode = !this.darkMode;
    // console.log(this.darkMode);
  }

}
