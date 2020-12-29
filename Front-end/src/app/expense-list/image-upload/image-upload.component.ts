import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output, Testability } from '@angular/core';
import { Expense } from 'src/app/models/expense';
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
  @Input() currentExpense?: Expense; 

  constructor(private imageService: ImageService, private http: HttpClient) {}

  onFileSelected(event: any) {
    let size: number = event.target.files[0].size;
    if(size > 5120) {
      alert("Image size is too big, choose something blow 5 kB!");
    } else {
      this.selectedFile = event.target.files[0];
    }
  }

  onSubmit() {
    if(this.selectedFile != undefined && this.currentExpense != undefined) {

      this.imageService.uploadImage(this.selectedFile, <string><unknown>this.currentExpense.expense_id).subscribe(res => {
            console.log(res);
          });
    }
  }

  ngOnInit(): void {
    // console.log(this.currentExpense?.expense_id);
  }

}
