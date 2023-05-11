
import React,{ useState } from 'react'
import { Outlet, Link, useParams, useNavigate } from 'react-router-dom'
import { UploadOutlined, UserOutlined, VideoCameraOutlined, FileTextOutlined, ProfileOutlined, GithubOutlined, BranchesOutlined, SettingOutlined } from '@ant-design/icons';
import { Layout, Menu, theme, Button, Tooltip } from 'antd'
import './common/common.styl'

const { Header, Content, Footer, Sider } = Layout
const App = () => {
  // const [collapsed, setCollapsed] = useState(false)
  const {
    token: { colorBgContainer },
  } = theme.useToken()

  // const iconMap = {
  //   'sql': <BranchesOutlined />,
  //   'task-manage': <FileTextOutlined />,
  // }

  const menuMap = [
    {
      key: 'job',
      icon: BranchesOutlined,
      label: 'Job',
      url: 'job',
    },
    // {
    //   key: 'catalog',
    //   icon: FileTextOutlined,
    //   label: 'Catalog',
    //   url: 'catalog',
    // },
    {
      key: 'catalog',
      icon: SettingOutlined,
      label: 'Catalog',
      url: 'catalog',
    },
    
  ]
  return (
    <Layout>
      <Sider
        breakpoint="lg"
      >
        <div className="logo" />
        <Menu
          theme="dark"
          mode="inline"
          defaultSelectedKeys={['4']}
          items={menuMap.map(
            (item, index) => ({
              key: String(index + 1),
              icon: React.createElement(item.icon),
              label: <Link 
              to={`/${item.url}`}
            >{item.label}</Link>,
            }),
          )
        }
        />
      </Sider>
      <Layout>
        <Header
          className="FBV FBAE header-box"
        >
          <div className=''>
            <Tooltip title='Document'>
              <ProfileOutlined style={{color: '#fff', fontSize: 16}} className='mr32 hand' />
            </Tooltip>
            <Tooltip title='GitHub'>
              <GithubOutlined style={{color: '#fff', fontSize: 16}} className='mr32 hand' />
            </Tooltip>
            <Button type='link'>EN</Button>
          </div>
          
        </Header>
        <Content
          style={{
          }}
        >
          <div
            style={{
              minHeight: 360,
              background: colorBgContainer,
            }}
          >
            <Outlet />
          </div>
        </Content>
        <Footer
          style={{
            textAlign: 'center',
          }}
        >
          Flink SQL Lineage  ©2023
        </Footer>
      </Layout>
    </Layout>
  );
}

export default App
