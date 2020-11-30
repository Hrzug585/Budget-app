import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.compoment.html',
  styles: [`
    app-main {
      display: block;
      height: 100%
    }
  `]
})
export class AppComponent {
  title = 'Front-end';

  constructor() { }

  ngOnInit() {
  }
}
