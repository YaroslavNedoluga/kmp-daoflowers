import SwiftUI
import shared

struct ContentView: View {

    @StateObject var vm = ViewModel()

	var body: some View {
        Text(vm.text)
	}
}

extension ContentView {
    
    @MainActor
    class ViewModel: ObservableObject {

        private let getFlowerTypesUseCase = CatalogKoinModule().getFlowerTypesUseCase
        
        @Published var text = "Loading..."

        init() {
            Task {
                do {
                    let flowerTypes = try await getFlowerTypesUseCase.invoke()
                    text = "\(flowerTypes.map { $0 })"
                } catch {
                    text = "Error"
                }
            }
        }

    }
}
