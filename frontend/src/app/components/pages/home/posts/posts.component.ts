import { Component } from '@angular/core';
import { Post } from 'src/app/inter/post';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent {
  readonly baseUrl = "../../../../../../assets/images"
  listPost :Post[]=[
    {

      id:1,
      caption:"Hổ tướng",
      file:[`${this.baseUrl}/363852794_309313831514033_2391794244875121261_n.jpg`],
      like:100,
      comment:123,
      date:2,
      author_name:"vo_tong"
    },
    {

      id:2,
      caption:"Đạt đến đây",
      file:[`${this.baseUrl}/1614211604141.jpg`],
      like:10000,
      comment:12345,
      date:3,
      author_name:"Tuand_Dat"
    },
    {

      id:3,
      caption:"bánh kem nho nhỏ",
      file:[`${this.baseUrl}/androidparty.png`],
      like:10000,
      comment:15,
      date:35,
      author_name:"kotlin77uu"
    },
]
 
}
