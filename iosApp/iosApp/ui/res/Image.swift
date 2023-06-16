import Foundation
import shared
import SwiftUI

extension Image {
    init(resource: KeyPath<SharedRes.images, ImageResource>) {
        self.init(uiImage: SharedRes.images()[keyPath: resource].toUIImage()!)
    }
}
