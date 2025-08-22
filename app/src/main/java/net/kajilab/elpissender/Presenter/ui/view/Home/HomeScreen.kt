package net.kajilab.elpissender.Presenter.ui.view.Home

import androidx.compose.runtime.Composable
import net.kajilab.elpissender.Presenter.ui.view.Components.WebViewComponent

@Composable
fun HomeScreen(
    topAppBarActions: ( List<@Composable () -> Unit>) -> Unit
) {
    // テスト用のGeoJSONデータ
    val testGeoJson = """
     {
        "type": "FeatureCollection",
        "crs": { "type": "name", "properties": { "name": "CRS:PIXEL" } },
        "features": [
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [780, 91],
                  [780, 390],
                  [80, 390],
                  [80, 440],
                  [370, 440],
                  [370, 840],
                  [80, 840],
                  [80, 920],
                  [780, 920],
                  [780, 1431],
                  [839, 1431],
                  [841, 91]
                ]
              ]
            },
            "properties": {
              "id": "R073",
              "name": "Room073",
              "type": "room",
              "area": 354190
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [850, 1290],
                  [1090, 1290],
                  [1090, 1430],
                  [850, 1430],
                  [850, 1290]
                ]
              ]
            },
            "properties": {
              "id": "R004",
              "name": "Room004",
              "type": "room",
              "area": 34869
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [850, 990],
                  [1090, 990],
                  [1090, 1280],
                  [850, 1280],
                  [850, 990]
                ]
              ]
            },
            "properties": {
              "id": "R008",
              "name": "Room008",
              "type": "room",
              "area": 71467
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [650, 930],
                  [770, 930],
                  [770, 1220],
                  [650, 1220],
                  [650, 930]
                ]
              ]
            },
            "properties": {
              "id": "R010",
              "name": "Room010",
              "type": "room",
              "area": 33861
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [460, 930],
                  [640, 930],
                  [640, 1220],
                  [460, 1220],
                  [460, 930]
                ]
              ]
            },
            "properties": {
              "id": "R011",
              "name": "Room011",
              "type": "room",
              "area": 51433
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [210, 930],
                  [450, 930],
                  [450, 1220],
                  [210, 1220],
                  [210, 930]
                ]
              ]
            },
            "properties": {
              "id": "R012",
              "name": "Room012",
              "type": "room",
              "area": 67544
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [80, 930],
                  [200, 930],
                  [200, 1220],
                  [80, 1220],
                  [80, 930]
                ]
              ]
            },
            "properties": {
              "id": "R016",
              "name": "Room016",
              "type": "room",
              "area": 33388
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [850, 690],
                  [1090, 690],
                  [1090, 980],
                  [850, 980],
                  [850, 690]
                ]
              ]
            },
            "properties": {
              "id": "R022",
              "name": "Room022",
              "type": "room",
              "area": 72050
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [850, 540],
                  [1090, 540],
                  [1090, 680],
                  [850, 680],
                  [850, 540]
                ]
              ]
            },
            "properties": {
              "id": "R050",
              "name": "Room050",
              "type": "room",
              "area": 35691
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [430, 450],
                  [770, 450],
                  [770, 870],
                  [430, 870],
                  [430, 450]
                ]
              ]
            },
            "properties": {
              "id": "R056",
              "name": "Room056",
              "type": "room",
              "area": 94347
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [80, 580],
                  [360, 580],
                  [360, 830],
                  [80, 830],
                  [80, 580]
                ]
              ]
            },
            "properties": {
              "id": "R057",
              "name": "Room057",
              "type": "room",
              "area": 73746
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [80, 450],
                  [360, 450],
                  [360, 570],
                  [80, 570],
                  [80, 450]
                ]
              ]
            },
            "properties": {
              "id": "R058",
              "name": "Room058",
              "type": "room",
              "area": 73746
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [850, 390],
                  [1090, 390],
                  [1090, 535],
                  [850, 535],
                  [850, 390]
                ]
              ]
            },
            "properties": {
              "id": "R060",
              "name": "Room060",
              "type": "room",
              "area": 35243
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [80, 90],
                  [200, 90],
                  [200, 380],
                  [80, 380],
                  [80, 90]
                ]
              ]
            },
            "properties": {
              "id": "R063",
              "name": "Room063",
              "type": "room",
              "area": 33763
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [210, 90],
                  [450, 90],
                  [450, 380],
                  [210, 380],
                  [210, 90]
                ]
              ]
            },
            "properties": {
              "id": "R066",
              "name": "Room066",
              "type": "room",
              "area": 67497
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [460, 90],
                  [640, 90],
                  [640, 380],
                  [460, 380],
                  [460, 90]
                ]
              ]
            },
            "properties": {
              "id": "R069",
              "name": "Room069",
              "type": "room",
              "area": 51855
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [650, 90],
                  [770, 90],
                  [770, 380],
                  [650, 380],
                  [650, 90]
                ]
              ]
            },
            "properties": {
              "id": "R074",
              "name": "Room074",
              "type": "room",
              "area": 33729,
              "highlight": true
            }
          },
          {
            "type": "Feature",
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [850, 90],
                  [1090, 90],
                  [1090, 380],
                  [850, 380],
                  [850, 90]
                ]
              ]
            },
            "properties": {
              "id": "R075",
              "name": "Room075",
              "type": "room",
              "area": 72292
            }
          }
        ]
      }
    """.trimIndent()

    WebViewComponent(
        topAppBarActions = topAppBarActions,
        geoJsonString = testGeoJson,
        highlightRoomId = "R066"
    )
}
