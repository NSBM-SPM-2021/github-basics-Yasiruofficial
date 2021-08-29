import {AfterViewInit, Component, Input, OnInit} from '@angular/core';
import DataSource from "devextreme/data/data_source";
import ArrayStore from "devextreme/data/array_store";

@Component({
  selector: 'app-detail-grid',
  templateUrl: './detail-grid.component.html',
  styleUrls: ['./detail-grid.component.css']
})
export class DetailGridComponent implements OnInit,AfterViewInit {

  ngOnInit(): void {
    console.log("DetailGridComponent ngOnInit")
  }

  @Input()
  key: number = 0;

  tasksDataSource : DataSource = {} as DataSource;
  tasks: Task[] = [];

  constructor() {
    //TODO load granted authorities with permissions
  }

  ngAfterViewInit() {
    this.tasksDataSource = new DataSource({
      store: new ArrayStore({
        data: this.tasks,
        key: "id"
      }),
      filter: ["id", "=", this.key]
    })
  }

  // completedValue(rowData : any) {
  //   return rowData.Status == "Completed";
  // }

}
