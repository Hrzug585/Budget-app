import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Testability } from '@angular/core';
import { ImageService } from 'src/app/services/image.service';

class ImageSnippet {
  constructor(public src: string, public file: File) {}
}

@Component({
  selector: 'app-image-upload',
  templateUrl: 'image-upload.component.html',
  styles: [
  ]
})
export class ImageUploadComponent implements OnInit {
  selectedFile?: File;

  constructor(private imageService: ImageService, private http: HttpClient) {}

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  onSubmit() {
    if(this.selectedFile != undefined) {

      
      const fd = new FormData();
      fd.append('image', this.selectedFile, this.selectedFile.name);

      this.http.post('http://localhost:9889/api/image/create', fd)
        .subscribe(res => {
          console.log(res);
        });
    }
  }

  ngOnInit(): void {}

}
