import React from 'react'
import ReactDOM from 'react-dom'
import { HashRouter, Routes, Route } from 'react-router-dom'
import './index.css'
import App from './App'
import PageLogin from './page-login'
import PageJob from './page-sql'
import JobSql from './page-sql/job-sql'
import JobList from './page-sql/job-list'
import PageJobList from './page-sql/job-list'
import PageCatalog from './page-catalog'
import PageCatalogList from './page-catalog/catalog-list'
import PageCatalogDetail from './page-catalog/catalog-detail'
import PageCatalogDetailTableInfo from './page-catalog/catalog-detail/detail-table-info'
import PageCatalogDetailFunctionInfo from './page-catalog/catalog-detail/detail-function-info'
import PagePlugin from './page-plugin'
import PagePluginList from './page-plugin/plugin-list'
import PageUserManage from './page-user-manage'
import PageUser from './page-user-manage/user'
import PageRole from './page-user-manage/role'



const ReactSample = () => {
  return <HashRouter>
    <Routes>
      <Route path="/" element={<App />}
      
      >
        <Route index element={<PageJob />} />
        <Route path="job" element={<PageJob />}>
          <Route index element={<JobList />} />
          <Route path="list" element={<JobList />} />
          <Route path="sql?/:id" element={<JobSql />} />
        </Route>
        <Route path="catalog" element={<PageCatalog />}>
          <Route index element={<PageCatalogList />} />
          <Route path="list" element={<PageCatalogList />} />
          <Route path=":id" element={<PageCatalogDetail />}>
            <Route path=":databaseName/table?/:itemId" element={<PageCatalogDetailTableInfo />} />
            <Route path=":databaseName/function?/:itemId" element={<PageCatalogDetailFunctionInfo />} />
          </Route>
        </Route>
        <Route path="plugin" element={<PagePlugin />}>
          <Route index element={<PagePluginList />} />
          <Route path="list" element={<PagePluginList />} />
        </Route>
        <Route path="user-manage" element={<PageUserManage />}>
          <Route index element={<PageUser />} />
          <Route path="user" element={<PageUser />} />
          <Route path="role" element={<PageRole />} />
        </Route>   
        <Route
          path="*"
          element={
            <main style={{ padding: '1rem' }}>
              <p className="fc45">正在开发建设中，敬请期待～</p>
            </main>
          }
        />
      </Route>
      <Route path="/login" element={<PageLogin />}>
      </Route>
    </Routes>
  </HashRouter>
}
export default ReactSample

ReactDOM.render(<ReactSample />, document.getElementById('root'))
