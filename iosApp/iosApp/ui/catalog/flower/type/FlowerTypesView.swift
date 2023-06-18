import Foundation
import SwiftUI
import shared

struct FlowerTypesView: View {
    @StateObject var vm = ViewModel()
    
    var body: some View {
        Text(vm.items.map { "\($0)" }.joined(separator: "\n"))
    }
}

extension FlowerTypesView {
    
    @MainActor
    class ViewModel: ObservableObject {

        private let getFlowerTypesUseCase = CatalogKoinModule().getFlowerTypesUseCase
        private let flowerTypeMapper = CatalogKoinModule().flowerTypeMapper
        
        @Published var items: [FlowerTypeItem] = []

        init() {
            Task {
                items = try await flowerTypeMapper.map(list: getFlowerTypesUseCase.invoke())
            }
        }
    }
}
